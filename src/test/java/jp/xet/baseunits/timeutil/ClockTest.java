/*
 * Copyright 2011 Daisuke Miyamoto. (http://d.hatena.ne.jp/daisuke-m)
 * Copyright 2010-2011 TRICREO, Inc. (http://tricreo.jp/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * ----
 * Copyright (c) 2004 Domain Language, Inc. (http://domainlanguage.com)
 * This free software is distributed under the "MIT" licence.
 * For more information, see http://timeandmoney.sourceforge.net.
 */
package jp.xet.baseunits.timeutil;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.TimeZone;

import jp.xet.baseunits.time.CalendarDate;
import jp.xet.baseunits.time.TimePoint;
import jp.xet.baseunits.time.TimeSource;

import org.junit.After;
import org.junit.Test;

/**
 * {@link Clock}のテストクラス。
 */
public class ClockTest {
	
	TimePoint dec1_5am_gmt = TimePoint.atGMT(2004, 12, 1, 5, 0);
	
	TimeZone gmt = TimeZone.getTimeZone("Universal");
	
	TimeZone pt = TimeZone.getTimeZone("America/Los_Angeles");
	
	TimeZone ct = TimeZone.getTimeZone("America/Chicago");
	
	/** 現在時間を問われた時、常に{@link #dec1_5am_gmt}を返す {@link TimeSource} */
	TimeSource dummySourceDec1_5h = new TimeSource() {
		
		@Override
		public TimePoint now() {
			return dec1_5am_gmt;
		}
	};
	
	
	/**
	 * テストの情報を破棄する。
	 * 
	 * @throws Exception 例外が発生した場合
	 */
	@After
	public void tearDown() throws Exception {
		Clock.reset();
	}
	
	/**
	 * {@link Clock#now()}のテスト。
	 * 
	 * @throws Exception 例外が発生した場合
	 */
	@Test
	public void test01_Now() throws Exception {
		Clock.setTimeSource(dummySourceDec1_5h);
		assertThat(Clock.now(), is(dec1_5am_gmt));
	}
	
	//
	/**
	 * {@link Clock#now()}で例外が発生しないこと。
	 * 
	 * [ 1466694 ] Clock.now() should use default TimeSource
	 * 
	 * @throws Exception 例外が発生した場合
	 */
	@Test
	public void test02_NowDoesntBreak() throws Exception {
		Clock.now();
	}
	
	/**
	 * {@link Clock#today(TimeZone)}のテスト。
	 * 
	 * @throws Exception 例外が発生した場合
	 */
	@Test
	public void test03_Today() throws Exception {
		Clock.setTimeSource(dummySourceDec1_5h);
		
		assertThat(Clock.today(gmt), is(CalendarDate.from(2004, 12, 1)));
		assertThat(Clock.now(), is(dec1_5am_gmt));
		
		assertThat(Clock.today(pt), is(CalendarDate.from(2004, 11, 30)));
		assertThat(Clock.now(), is(dec1_5am_gmt));
	}
}