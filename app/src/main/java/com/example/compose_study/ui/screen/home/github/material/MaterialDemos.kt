package com.example.compose_study.ui.screen.home.github.material

import SnackbarDemo
import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory
import com.example.compose_study.ui.screen.home.github.material.button.ButtonExample
import com.example.compose_study.ui.screen.home.github.material.card.CardDemo
import com.example.compose_study.ui.screen.home.github.material.checkbox.CheckBoxDemo
import com.example.compose_study.ui.screen.home.github.material.circularprogress.CircularProgressIndicatorSample
import com.example.compose_study.ui.screen.home.github.material.dropdown.DropdownDemo
import com.example.compose_study.ui.screen.home.github.material.floatingactionbutton.FloatingActionButtonDemo
import com.example.compose_study.ui.screen.home.github.material.linearprogress.LinearProgressIndicatorSample
import com.example.compose_study.ui.screen.home.github.material.modaldrawer.ModalDrawerSample
import com.example.compose_study.ui.screen.home.github.material.radiobutton.RadioButtonSample
import com.example.compose_study.ui.screen.home.github.material.alertdialog.AlertDialogSample
import com.example.compose_study.ui.screen.home.github.material.appbar.topappbar.TopAppBarSample
import com.example.compose_study.ui.screen.home.github.material.scaffold.ScaffoldDemo

val MaterialDemos = ReplaceableViewCategory(
    "MaterialDemos",
    listOf(
        ComposableReplaceableView("AlertDialogSample") { AlertDialogSample() },
        ComposableReplaceableView("ButtonExample") { ButtonExample() },
        ComposableReplaceableView("CardDemo") { CardDemo() },
        ComposableReplaceableView("CheckBoxDemo") { CheckBoxDemo() },
        ComposableReplaceableView("CircularProgressIndicatorSample") { CircularProgressIndicatorSample() },
        ComposableReplaceableView("DropdownDemo") { DropdownDemo() },
        ComposableReplaceableView("FloatingActionButtonDemo") { FloatingActionButtonDemo() },
        ComposableReplaceableView("LinearProgressIndicatorSample") { LinearProgressIndicatorSample() },
        ComposableReplaceableView("ModalDrawerLayoutSample") { ModalDrawerSample() },
        ComposableReplaceableView("RadioButtonSample") { RadioButtonSample() },
        ComposableReplaceableView("ScaffoldDemo") { ScaffoldDemo() },
        ComposableReplaceableView("SnackbarDemo") { SnackbarDemo() },
        ComposableReplaceableView("TopAppBarSample") { TopAppBarSample() },

        )
)
