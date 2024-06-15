package com.example.c001apk.compose.ui.coolpic

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.c001apk.compose.ui.component.CommonScreen
import com.example.c001apk.compose.util.ReportType

/**
 * Created by bggRGjQaUbCoE on 2024/6/12
 */
@Composable
fun CoolPicContentScreen(
    title: String,
    type: String,
    refreshState: Boolean,
    resetRefreshState: () -> Unit,
    paddingValues: PaddingValues,
    onViewUser: (String) -> Unit,
    onViewFeed: (String, Boolean) -> Unit,
    onOpenLink: (String, String?) -> Unit,
    onCopyText: (String?) -> Unit,
    onReport: (String, ReportType) -> Unit,
) {

    val viewModel =
        hiltViewModel<CoolPicContentViewModel, CoolPicContentViewModel.ViewModelFactory>(key = title + type) { factory ->
            factory.create(title, type)
        }

    CommonScreen(
        viewModel = viewModel,
        refreshState = refreshState,
        resetRefreshState = resetRefreshState,
        paddingValues = paddingValues,
        onViewUser = onViewUser,
        onViewFeed = onViewFeed,
        onOpenLink = onOpenLink,
        onCopyText = onCopyText,
        onReport = onReport,
        onViewFFFList = { _, _, _, _ -> },
    )

}