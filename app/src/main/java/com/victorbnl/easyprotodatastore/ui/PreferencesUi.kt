import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.victorbnl.easyprotodatastore.R
import com.victorbnl.easyprotodatastore.viewmodels.PreferencesViewModel

class PreferencesUi(private val viewModel: PreferencesViewModel) {
    @Composable
    fun MainScreen() {
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(32.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(stringResource(R.string.title), fontSize = 28.sp)
                Preferences()
                Buttons(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

    @Composable
    fun Preferences() {
        val preferencesState by viewModel.preferences.observeAsState()
        preferencesState?.let { preferences ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    value = preferences.username,
                    onValueChange = { newValue ->
                        viewModel.preferences.postValue(
                            preferences.copy(username = newValue)
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(stringResource(R.string.username)) }
                )
                OutlinedTextField(
                    value = preferences.age.toString(),
                    onValueChange = { newValue ->
                        try {
                            viewModel.preferences.postValue(
                                preferences.copy(age = newValue.toInt())
                            )
                        } catch (_: NumberFormatException) {}
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(stringResource(R.string.age)) }
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(stringResource(R.string.notifications))
                    Checkbox(
                        checked = preferences.notifications,
                        onCheckedChange = { newValue ->
                            viewModel.preferences.postValue(
                                preferences.copy(notifications = newValue)
                            )
                        }
                    )
                }
            }
        }
    }

    @Composable
    fun Buttons(modifier: Modifier) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { viewModel.load() }) {
                Text(stringResource(R.string.load))
            }
            Button(onClick = { viewModel.save() }) {
                Text(stringResource(R.string.save))
            }
        }
    }
}