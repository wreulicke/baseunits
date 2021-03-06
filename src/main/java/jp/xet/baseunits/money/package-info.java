/*
 * Copyright 2010-2015 Miyamoto Daisuke.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 金額を表すクラスを中心としたクラス群。
 * 
 * <p>Java標準APIの範囲内で、金額は{@link java.util.Currency}と数値型で表現する。
 * 金額に対する演算をする際に、通貨単位が一致していることや、丸め処理への対応、
 * 通貨単位が持つ最低単位（日本円は1円、USドルは1セント=0.01ドルなど）を意識する必要があり、煩雑である。</p>
 * 
 * <p>このパッケージは、金額を表す{@link jp.xet.baseunits.money.Money}クラスを中心に、
 * その演算を行うための各種クラス群を提供する。</p>
 */
package jp.xet.baseunits.money;

