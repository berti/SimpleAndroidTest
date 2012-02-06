/*
 * Copyright 2012 Alberto Salmerón Moreno
 * 
 * This file is part of SimpleAndroidTest - https://github.com/berti/SimpleAndroidTest
 * 
 * SimpleAndroidTest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SimpleAndroidTest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SimpleAndroidTest.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.primoberti.simpleandroidtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SimpleAndroidTestActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button = (Button) findViewById(R.id.aboutButton);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showAboutDialog();
			}
		});
	}

	private void showAboutDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				SimpleAndroidTestActivity.this);
		builder.setTitle(R.string.about_dialog_title);
		builder.setMessage(R.string.about_dialog_content);
		builder.setPositiveButton(android.R.string.ok,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		AlertDialog dialog = builder.create();
		dialog.show();
	}

}