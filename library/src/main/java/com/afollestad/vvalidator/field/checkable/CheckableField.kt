/**
 * Designed and developed by Aidan Follestad (@afollestad)
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
@file:Suppress("unused")

package com.afollestad.vvalidator.field.checkable

import android.widget.CompoundButton
import androidx.annotation.IdRes
import com.afollestad.vvalidator.ValidationContainer
import com.afollestad.vvalidator.assertion.CustomViewAssertion
import com.afollestad.vvalidator.assertion.checkable.CompoundButtonAssertions.CheckedStateAssertion
import com.afollestad.vvalidator.field.FormField

/**
 * Represents a compound button field, like a checkbox or radio button.
 *
 * @author Aidan Follestad (@afollestad)
 */
class CheckableField internal constructor(
  container: ValidationContainer,
  @IdRes id: Int,
  name: String?
) : FormField<CheckableField, CompoundButton>(container, id, name) {

  /** Asserts the view is checked. */
  fun isChecked() = assert(CheckedStateAssertion(true))

  /** Asserts the view is not checked. */
  fun isNotChecked() = assert(CheckedStateAssertion(false))

  /** Adds a custom inline assertion for the checkable field. */
  fun assert(
    description: String,
    matcher: (CompoundButton) -> Boolean
  ) = assert(CustomViewAssertion(description, matcher))
}
