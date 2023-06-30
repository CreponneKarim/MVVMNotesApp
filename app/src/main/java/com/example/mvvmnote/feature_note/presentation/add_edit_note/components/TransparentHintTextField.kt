package com.example.mvvmnote.feature_note.presentation.add_edit_note.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun TransparentHintTextField(
    text:String,
    hint:String,
    modifier: Modifier = Modifier,
    isHintVisible:Boolean = true,
    onValueChange : (String)->Unit,
    textStyle: TextStyle = TextStyle.Default,
    singleLine:Boolean = false,
    onFocusChange : (FocusState)->Unit
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ){
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    onFocusChange(it)
                },
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
        )
        if(isHintVisible)
            Text(text = hint,style = textStyle, color = Color.DarkGray)
    }
}