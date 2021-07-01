package com.example.compose_study.ui.screen.home.jetpack_compose.material

import SnackbarSample
import com.example.compose_study.ui.common.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.common.replaceable.ReplaceableViewCategory
import com.example.compose_study.ui.screen.home.jetpack_compose.material.button.ButtonSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.card.CardSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.checkbox.CheckBoxSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.circularprogress.CircularProgressIndicatorSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.dropdown.DropdownSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.floatingactionbutton.FloatingActionButtonSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.linearprogress.LinearProgressIndicatorSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.modaldrawer.ModalDrawerSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.radiobutton.RadioButtonSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.alertdialog.AlertDialogSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.appbar.topappbar.TopAppBarSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.scaffold.ScaffoldSample

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
