/**
 *  Copyright 2012 Yannick Roffin
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.yroffin.rocksmith.model.impl;

import java.text.DecimalFormat;
import java.util.Locale;

import org.yroffin.rocksmith.model.IAnchor;

public class AnchorEntity implements IAnchor {

	private final float time;
	private final int fret;

	public static IAnchor factory(float time, int fret) {
		AnchorEntity entity = new AnchorEntity(time, fret);
		return entity;
	}

	private AnchorEntity(float time, int fret) {
		this.time = time;
		this.fret = fret;
	}

	public StringBuilder asXml(StringBuilder xml) {
		DecimalFormat df = (DecimalFormat) DecimalFormat
				.getNumberInstance(Locale.ENGLISH);
		df.setMaximumFractionDigits(3);
		df.setMinimumFractionDigits(3);
		df.setDecimalSeparatorAlwaysShown(true);
		xml.append("\n<anchor time=\"" + df.format(time) + "\" fret=\"" + fret
				+ "\" />");
		return xml;
	}
}
