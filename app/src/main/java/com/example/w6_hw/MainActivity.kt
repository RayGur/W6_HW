package com.example.w6_lab

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.w6_hw.R

class MainActivity : AppCompatActivity() {

    // 宣告變數
    private lateinit var edName: EditText
    private lateinit var tvText: TextView
    private lateinit var tvName: TextView
    private lateinit var tvWinner: TextView
    private lateinit var tvMmora: TextView
    private lateinit var tvCmora: TextView
    private lateinit var btnScissor: RadioButton
    private lateinit var btnStone: RadioButton
    private lateinit var btnPaper: RadioButton
    private lateinit var btnMora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 連結 layout

        // 綁定 XML 的元件
        edName = findViewById(R.id.ed_name)
        tvText = findViewById(R.id.tv_inputname)
        tvName = findViewById(R.id.tv_end_name)
        tvWinner = findViewById(R.id.tv_end_winner)
        tvMmora = findViewById(R.id.tv_end_player)
        tvCmora = findViewById(R.id.tv_end_bot)
        btnScissor = findViewById(R.id.btn_scissors)
        btnStone = findViewById(R.id.btn_rock)
        btnPaper = findViewById(R.id.btn_paper)
        btnMora = findViewById(R.id.btn_game)

        // 設置按鈕點擊監聽器
        btnMora.setOnClickListener {
            // 判斷玩家是否輸入姓名
            if (edName.text.isEmpty()) {
                tvText.text = "insert player name"
            } else {
                // 顯示玩家姓名與出拳
                tvName.text = "name\n${edName.text}"

                when {
                    btnScissor.isChecked -> tvMmora.text = "Player\nScissors"
                    btnStone.isChecked -> tvMmora.text = "Player\nRock"
                    else -> tvMmora.text = "Player\nPaper"
                }

                // 使用亂數產生電腦出拳，值為 0~2
                val computerRandom = (0..2).random()

                // 顯示電腦出拳
                tvCmora.text = when (computerRandom) {
                    0 -> "Bot\nScissors"
                    1 -> "Bot\nRock"
                    else -> "Bot\nPaper"
                }

                // 判斷勝負
                when {
                    (btnScissor.isChecked && computerRandom == 2) ||
                            (btnStone.isChecked && computerRandom == 0) ||
                            (btnPaper.isChecked && computerRandom == 1) -> {
                        tvWinner.text = "Winner\n${edName.text}"
                        tvText.text = "Player wins!"
                    }
                    (btnScissor.isChecked && computerRandom == 1) ||
                            (btnStone.isChecked && computerRandom == 2) ||
                            (btnPaper.isChecked && computerRandom == 0) -> {
                        tvWinner.text = "Winner\nBot"
                        tvText.text = "Bot Wins"
                    }
                    else -> {
                        tvWinner.text = "Winner\n Tie"
                        tvText.text = "Tie, please try again"
                    }
                }
            }
        }
    }
}
