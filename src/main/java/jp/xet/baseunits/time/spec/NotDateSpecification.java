/*
 * Copyright 2011 Daisuke Miyamoto. (http://d.hatena.ne.jp/daisuke-m)
 * Created on 2011/10/25
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
 */
package jp.xet.baseunits.time.spec;

import java.util.Iterator;

import jp.xet.baseunits.time.CalendarDate;
import jp.xet.baseunits.time.CalendarInterval;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.Validate;

/**
 * TODO for daisuke
 */
public class NotDateSpecification extends AbstractDateSpecification {
	
	final DateSpecification spec1;
	
	
	/**
	 * インスタンスを生成する。
	 * 
	 * @param spec1 Specification instance to not.
	 */
	public NotDateSpecification(DateSpecification spec1) {
		Validate.notNull(spec1);
		this.spec1 = spec1;
	}
	
	@Override
	public CalendarDate firstOccurrenceIn(CalendarInterval interval) {
		Validate.notNull(interval);
		
		if (interval.hasLowerLimit()) {
			Iterator<CalendarDate> itr = interval.daysIterator();
			while (itr.hasNext()) {
				CalendarDate date = itr.next();
				if (isSatisfiedBy(date)) {
					return date;
				}
			}
		} else {
			// TODO ここ、算出できるか…？
			throw new NotImplementedException(NotDateSpecification.class);
		}
		return null;
	}
	
	@Override
	public boolean isSatisfiedBy(CalendarDate t) {
		return spec1.isSatisfiedBy(t) == false;
	}
}