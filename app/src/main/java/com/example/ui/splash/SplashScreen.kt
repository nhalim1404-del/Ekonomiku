package com.example.ui.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.PrimaryBlue
import com.example.ui.theme.PrimaryBlueDark
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {
    val scale = remember { Animatable(0.85f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        alpha.animateTo(1f, animationSpec = tween(600))
        scale.animateTo(1f, animationSpec = tween(600))
        delay(1400) // Total 2 seconds splash duration
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        PrimaryBlueDark,
                        PrimaryBlue,
                        Color(0xFF1E88E5)
                    )
                )
            )
            .testTag("splash_screen"),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(24.dp)
                .scale(scale.value)
                .alpha(alpha.value)
        ) {
            // SMANSA Logo Emblem
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(3.dp, AccentAmber, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_smansa),
                    contentDescription = "Logo SMAN 1 Pangkep",
                    modifier = Modifier.size(118.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // App Title
            Text(
                text = "EKONOMIKU",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 2.sp,
                color = Color.White
            )

            Text(
                text = "Ekonomi Kelas X Interaktif",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = AccentAmber
            )

            Spacer(modifier = Modifier.height(6.dp))

            Surface(
                color = Color.White.copy(alpha = 0.15f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Fase E • Kurikulum Merdeka",
                    fontSize = 11.sp,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            // School & Teacher Attribution
            Text(
                text = "SMAN 1 Pangkajene dan Kepulauan\n(SMANSA PANGKEP)",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = Color.White.copy(alpha = 0.95f),
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Guru Pengampu:\nNur Halim, S.Pd., Gr.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = AccentAmber.copy(alpha = 0.95f)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Kepala Sekolah: Syamsul Ardi, S.Pd., M.Pd.",
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                color = Color.White.copy(alpha = 0.75f)
            )

            Spacer(modifier = Modifier.height(32.dp))

            CircularProgressIndicator(
                color = AccentAmber,
                strokeWidth = 2.5.dp,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
