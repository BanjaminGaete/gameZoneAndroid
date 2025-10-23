package com.example.gamezone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.gamezone.navigation.AppNavigation
import com.example.gamezone.storage.AppDatabase
import com.example.gamezone.storage.ProductoRepository
import com.example.gamezone.storage.ProductViewModelFactory
import com.example.gamezone.viewModel.ProductoViewModel
import com.example.gamezone.ui.theme.GameZoneTheme
class MainActivity : ComponentActivity() {

    private val viewModel: ProductoViewModel by viewModels {
        ProductViewModelFactory(
            ProductoRepository(
                Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .productDao()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameZoneTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(viewModel)
                }
            }
        }
    }
}
