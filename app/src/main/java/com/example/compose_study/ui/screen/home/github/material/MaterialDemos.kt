package com.example.compose_study.ui.screen.home.github.material

import SnackbarSample
import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory
import com.example.compose_study.ui.screen.home.github.material.button.ButtonSample
import com.example.compose_study.ui.screen.home.github.material.card.CardSample
import com.example.compose_study.ui.screen.home.github.material.checkbox.CheckBoxSample
import com.example.compose_study.ui.screen.home.github.material.circularprogress.CircularProgressIndicatorSample
import com.example.compose_study.ui.screen.home.github.material.dropdown.DropdownSample
import com.example.compose_study.ui.screen.home.github.material.floatingactionbutton.FloatingActionButtonSample
import com.example.compose_study.ui.screen.home.github.material.linearprogress.LinearProgressIndicatorSample
import com.example.compose_study.ui.screen.home.github.material.modaldrawer.ModalDrawerSample
import com.example.compose_study.ui.screen.home.github.material.radiobutton.RadioButtonSample
import com.example.compose_study.ui.screen.home.github.material.alertdialog.AlertDialogSample
import com.example.compose_study.ui.screen.home.github.material.appbar.topappbar.TopAppBarSample
import com.example.compose_study.ui.screen.home.github.material.scaffold.ScaffoldSample

val MaterialSample = ReplaceableViewCategory(
    "MaterialSample",
    listOf(
        ComposableReplaceableView("AlertDialogSample") { AlertDialogSample() },
        ComposableReplaceableView("ButtonExample") { ButtonSample() },
        ComposableReplaceableView("CardSample") { CardSample() },
        ComposableReplaceableView("CheckBoxSample") { CheckBoxSample() },
        ComposableReplaceableView("CircularProgressIndicatorSample") { CircularProgressIndicatorSample() },
        ComposableReplaceableView("DropdownSample") { DropdownSample() },
        ComposableReplaceableView("FloatingActionButtonSample") { FloatingActionButtonSample() },
        ComposableReplaceableView("LinearProgressIndicatorSample") { LinearProgressIndicatorSample() },
        ComposableReplaceableView("ModalDrawerLayoutSample") { ModalDrawerSample() },
        ComposableReplaceableView("RadioButtonSample") { RadioButtonSample() },
        ComposableReplaceableView("ScaffoldSample") { ScaffoldSample() },
        ComposableReplaceableView("SnackbarSample") { SnackbarSample() },
        ComposableReplaceableView("TopAppBarSample") { TopAppBarSample() },

        )
)
