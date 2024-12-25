package com.example.composeproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeproj.ui.theme.ComposeProjTheme

data class Issue(
    val title: String,
    val status: String,
    val description: String,
    val createdAt: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjTheme {
                IssueScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IssueScreen() {
    val issues = listOf(
        Issue("Bump pyarrow from 7...", "Open", "NONE", "2023-11-9, 23:00 PM"),
        Issue("Français", "Open", "NONE", "2023-11-2, 9:38 AM"),
        Issue("Bump werkzeug from ...", "Open", "NONE", "2023-10-25, 18:52 PM"),
        Issue("Bump urllib3 from 1.2...", "Open", "NONE", "2023-10-17, 22:59 PM"),
        Issue("ORQA fine tuning with...", "Open", "NONE", "2023-10-9, 15:30 PM"),
        Issue("Bump pillow from 9.2...", "Open", "NONE", "2023-10-4, 0:35 AM")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Issues", fontSize = 20.sp, fontWeight = FontWeight.Bold) }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(issues) { issue ->
                IssueCard(issue)
            }
        }
    }
}

@Composable
fun IssueCard(issue: Issue) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = issue.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = issue.status,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = issue.description, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Created At: ${issue.createdAt}",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IssueScreenPreview() {
    ComposeProjTheme {
        IssueScreen()
    }
}
