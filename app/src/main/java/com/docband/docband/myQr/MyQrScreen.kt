package com.docband.docband.myQr

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import com.docband.docband.ui.theme.DocBandTheme


import com.docband.docband.ui.theme.montserratFamily
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import com.lightspark.composeqr.QrCodeView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.glxn.qrgen.android.QRCode

@Composable
fun QrView(NavControler: NavHostController) {

    DocBandTheme {
        Column {

            ToolBar(NavControler)
            Content ()

        }


    }

}


@Composable
fun ToolBar(NavControler: NavHostController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(onClick = { NavControler.popBackStack() }) {

            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Boton Regresar",
                tint = Color.White
            )

        }

        Text(
            text = "DocBand",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

}

@Composable
fun Content(){

    Column (modifier = Modifier.fillMaxSize()) {

        ShowQr()
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            ExportButton()
            ScanButton()
        }
    }


}

@Composable
fun rememberQrBitmapPainter(
    content: String,
    size: Dp = 150.dp,
    padding: Dp = 0.dp
): BitmapPainter {

    val density = LocalDensity.current
    val sizePx = with(density) { size.roundToPx() }
    val paddingPx = with(density) { padding.roundToPx() }


    var bitmap by remember(content) {
        mutableStateOf<Bitmap?>(null)
    }

    LaunchedEffect(bitmap) {
        if (bitmap != null) return@LaunchedEffect

        launch(Dispatchers.IO) {
            val qrCodeWriter = QRCodeWriter()

            val encodeHints = mutableMapOf<EncodeHintType, Any?>()
                .apply {
                    this[EncodeHintType.MARGIN] = paddingPx
                }

            val bitmapMatrix = try {
                qrCodeWriter.encode(
                    content, BarcodeFormat.QR_CODE,
                    sizePx, sizePx, encodeHints
                )
            } catch (ex: WriterException) {
                null
            }

            val matrixWidth = bitmapMatrix?.width ?: sizePx
            val matrixHeight = bitmapMatrix?.height ?: sizePx

            val newBitmap = Bitmap.createBitmap(
                bitmapMatrix?.width ?: sizePx,
                bitmapMatrix?.height ?: sizePx,
                Bitmap.Config.ARGB_8888,
            )

            for (x in 0 until matrixWidth) {
                for (y in 0 until matrixHeight) {
                    val shouldColorPixel = bitmapMatrix?.get(x, y) ?: false
                    val pixelColo = if (shouldColorPixel) Color.Black else Color.White

                    newBitmap.setPixel(x, y, Color.Black)
                }
            }

            bitmap = newBitmap
        }
    }

    return remember(bitmap) {
        val currentBitmap = bitmap ?: Bitmap.createBitmap(
            sizePx, sizePx,
            Bitmap.Config.ARGB_8888,
        ).apply { eraseColor(Color.Transparent) }

        BitmapPainter(currentBitmap.asImageBitmap())
    }
}

private fun Bitmap.setPixel(x: Int, y: Int, black: Color) {

}

fun eraseColor(transparent: Color) {

}

@Composable
fun ShowQr(){
 //________________________________________________________________________________________________________________________________
    Column (modifier = Modifier
        .fillMaxWidth()
        .height(620.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.padding(15.dp))
        Text(text = "Mi QR", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, fontFamily = montserratFamily)
        Spacer(modifier = Modifier.padding(15.dp))
        QrCodeView(
            data = "V-30835109",
            modifier = Modifier.size(280.dp)

        )


    }

//___________________________________________________________________________________________________________________________________
}


@Composable
fun ExportButton(){

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Exportar", fontSize = 18.sp)
        }

}

@Composable
fun ScanButton() {
    var resultadoEscaneo by remember { mutableStateOf("") }
    val scanLauncher = rememberLauncherForActivityResult(
        contract = ScanContract(),
        onResult = { result->
            resultadoEscaneo = result.contents?:""
    }
    )

    Button(onClick = {
        scanLauncher.launch(ScanOptions())
    }) {
        Text(text = "Escanear$resultadoEscaneo", fontSize = 18.sp)
    }


}




