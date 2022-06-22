package com.apptive.braini.presentation.view.Main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.braini.R
import com.apptive.braini.presentation.height
import com.apptive.braini.presentation.view.MainScreen
import com.apptive.braini.presentation.width
import com.apptive.braini.ui.theme.Blue300
import com.apptive.braini.ui.theme.LayoutPracticeTheme

@Composable
fun MemoTypeSelectScreen(){
    BasicContent {
        SelectBox()
    }
}

@Composable
private fun BasicContent(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .width(76)
            .wrapContentSize(Alignment.Center),
//            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Composable
private fun SelectBox(){
    Surface(
        shape = RoundedCornerShape(10),
//        elevation = 10.dp
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    color = Color(221, 229, 255)
//                    color = Color(185,204,255,100)
                )
                .padding(horizontal = 10.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            MemoTypeContent()
        }
    }
}

@Composable
private fun MemoTypeContent(){
    Text(
        text = "< 가이드라인 필요하신가요?",
        color = Color.Black,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(23.dp))
    Row {
        Tree()
        Spacer(modifier = Modifier.width(20.dp))
        mindmap()
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row {
        column()
        Spacer(modifier = Modifier.width(17.dp))
        nothing()
    }

}

@Composable
private fun BasicBox(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable BoxScope.()->Unit = {}
) {
    Box(
        modifier = Modifier
            .width(140.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(20))
            .background(Color.White)
            .clickable { onClick() },
        content = content,
        contentAlignment = Alignment.Center
    )
}

@Composable
private fun Tree(){
    Column(
    ){
        BasicBox(){
            Image(
                painter = painterResource(id = R.drawable.guideline_tree),
                contentDescription = null,
                modifier = Modifier.size(125.dp)
            )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row(){
            Spacer(modifier = Modifier.width(50.dp))
            Text(
                text = "트리",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun mindmap(){
    Column(){
        BasicBox(){
            Image(
                painter = painterResource(id = R.drawable.guideline_mindmap),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row(){
            Spacer(modifier = Modifier.width(50.dp))
            Text(
                text = "마인드맵",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun column(){
    Column(){
        BasicBox(){
            Image(
                painter = painterResource(id = R.drawable.guideline_column),
                contentDescription = null,
                modifier = Modifier.size(125.dp)
            )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row(){
            Spacer(modifier = Modifier.width(50.dp))
            Text(
                text = "세로 나열",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun nothing(){
    Column(){
        BasicBox(){
            Image(
                painter = painterResource(id = R.drawable.guideline_nothing),
                contentDescription = null,
                modifier = Modifier.size(125.dp)
            )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row(){
            Spacer(modifier = Modifier.width(50.dp))
            Text(
                text = "필요없음",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RoomCreateScreenPreview() {
    LayoutPracticeTheme() {

    }
    MemoTypeSelectScreen()
}