package com.example.gamezone.views


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gamezone.viewModel.ProductoViewModel
import androidx.compose.foundation.layout.systemBarsPadding

class ProductoScreen(private val navController: NavHostController? = null, private val viewModel: ProductoViewModel) {

    @Composable
    fun pantallaProducto() {
        val name by viewModel.name.collectAsState()
        val price by viewModel.price.collectAsState()
        val productList by viewModel.productList.collectAsState()

        Column(modifier = Modifier.padding(16.dp).systemBarsPadding()) {

            Text(
                text = "Gestionar productos",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth()

            )

            OutlinedTextField(
                value = name,
                onValueChange = { viewModel.onNameChange(it) },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = price,
                onValueChange = { viewModel.onPriceChange(it) },
                label = { Text("Precio") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { viewModel.saveProduct() },
                enabled = name.isNotBlank() && price.isNotBlank(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Productos guardados",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(productList) { product ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(text = "ID: ${product.id}", fontWeight = FontWeight.SemiBold)
                        Text(text = "Nombre: ${product.name}")
                        Text(text = "Precio: $${product.price}")
                    }
                    Divider()
                }
            }
        }
    }
}

