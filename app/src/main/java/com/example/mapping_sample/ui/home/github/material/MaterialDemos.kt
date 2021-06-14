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
