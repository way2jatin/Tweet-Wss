package com.twitter.presentation.base

import androidx.viewbinding.ViewBinding

interface BaseViewGroup<V : BaseViewModel, B : ViewBinding?> {
    val viewModel: V
    var binding: B
}