package demos

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        findViewById<Button>(R.id.showSnackbar).setOnClickListener { view ->
            Snackbar.make(view, "这是一个 Snackbar", Snackbar.LENGTH_LONG)
                .setAction("撤销") {
                    // 撤销操作
                }
                .show()
        }
    }
}
