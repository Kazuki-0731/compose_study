/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mapping_sample.ui.home.github.material


import SnackbarDemo
import com.example.mapping_sample.ui.home.demo.ComposableDemo
import com.example.mapping_sample.ui.home.demo.DemoCategory
import com.example.mapping_sample.ui.home.github.material.button.ButtonExample
import com.example.mapping_sample.ui.home.github.material.card.CardDemo
import com.example.mapping_sample.ui.home.github.material.checkbox.CheckBoxDemo
import com.example.mapping_sample.ui.home.github.material.circularprogress.CircularProgressIndicatorSample
import com.example.mapping_sample.ui.home.github.material.dropdown.DropdownDemo
import com.example.mapping_sample.ui.home.github.material.floatingactionbutton.FloatingActionButtonDemo
import com.example.mapping_sample.ui.home.github.material.linearprogress.LinearProgressIndicatorSample
import com.example.mapping_sample.ui.home.github.material.modaldrawer.ModalDrawerSample
import com.example.mapping_sample.ui.home.github.material.radiobutton.RadioButtonSample
import com.example.mapping_sample.ui.home.github.material.alertdialog.AlertDialogSample
import com.example.mapping_sample.ui.home.github.material.appbar.topappbar.TopAppBarSample
import com.example.mapping_sample.ui.home.github.material.scaffold.ScaffoldDemo


val MaterialDemos = DemoCategory(
    "MaterialDemos",
    listOf(
        ComposableDemo("AlertDialogSample") { AlertDialogSample() },
        ComposableDemo("ButtonExample") { ButtonExample() },
        ComposableDemo("CardDemo") { CardDemo() },
        ComposableDemo("CheckBoxDemo") { CheckBoxDemo() },
        ComposableDemo("CircularProgressIndicatorSample") { CircularProgressIndicatorSample() },
        ComposableDemo("DropdownDemo") { DropdownDemo() },
        ComposableDemo("FloatingActionButtonDemo") { FloatingActionButtonDemo() },
        ComposableDemo("LinearProgressIndicatorSample") { LinearProgressIndicatorSample() },
        ComposableDemo("ModalDrawerLayoutSample") { ModalDrawerSample() },
        ComposableDemo("RadioButtonSample") { RadioButtonSample() },
        ComposableDemo("ScaffoldDemo") { ScaffoldDemo() },
        ComposableDemo("SnackbarDemo") { SnackbarDemo() },
        ComposableDemo("TopAppBarSample") { TopAppBarSample() },

        )
)
