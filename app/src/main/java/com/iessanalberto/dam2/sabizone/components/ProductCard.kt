package com.iessanalberto.dam2.sabizone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.iessanalberto.dam2.sabizone.models.Product
import com.iessanalberto.dam2.sabizone.navigation.AppScreens

@Composable
fun ProductCard(product: Product, navController: NavController){
    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        modifier = Modifier.size(width = 500.dp, height = 200.dp),
        onClick = {navController.navigate(AppScreens.DetailScreen.route + "/" + product.name)}
    ) {
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(30.dp))
        {
            Image(painter = painterResource(product.foto), contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
                )
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(30.dp)
                )

            {
                Text(text = product.name, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(text = product.shortDescription)
            }
        }
    }
}