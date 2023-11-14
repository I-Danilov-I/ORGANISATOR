// Importieren Sie die benötigten Android- und Kotlin-Bibliotheken
package com.example.organisator

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

// Definieren Sie die MainActivity-Klasse, die von AppCompatActivity erbt
class MainActivity : AppCompatActivity() {

    // Deklaration der Liste und des Adapters auf Klassenebene, damit sie in mehreren Methoden verwendet werden können
    private lateinit var liste: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var listDataManager: ListDataManager
    private lateinit var soundManager: SoundManager  // Deklarieren Sie soundManager hier

    // In Ihrer MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Erstellen Sie eine Instanz von ListDataManager und SoundManager
        listDataManager = ListDataManager(this)
        soundManager = SoundManager(this)  // Erstellen Sie eine Instanz von SoundManager

        // Initialisieren Sie die Liste mit einigen Werten und lesen Sie die Liste aus dem ListDataManager
        liste = mutableListOf("Äpfel", "Birnen", "Eier")
        liste = listDataManager.readList()

        // Erstellen Sie einen Adapter für die Liste
        adapter = MyAdapter(this, liste)

        // Rufen Sie die setupAnimation-Methode der AnimationSetup-Klasse auf
        AnimationSetup(this).setupAnimation()
        // Rufen Sie die setupList-Methode der ListSetup-Klasse auf und übergeben Sie die benötigten Parameter
        ListSetup(this, liste, adapter, soundManager).setupList()
        // Rufen Sie die setupButtons-Methode der ButtonSetup-Klasse auf und übergeben Sie die benötigten Parameter
        ButtonSetup(this, liste, adapter, soundManager).setupButtons()  // Übergeben Sie soundManager hier



        // Benutzer fargen ob Benachritugung ativieren
        val notificationDialogManager = NotificationManager(this)
        notificationDialogManager.showNotificationSettingsDialog()

        // Test Benachritigung absenden
        // TestNotificationManager(this).sendTestNotification()

        // Tägliche Benachrichtigung
        NotificationManager(this).setupDailyNotification()
    }

    // Überschreiben Sie die onPause-Methode, um die Liste zu speichern, wenn die App pausiert wird
    override fun onPause() {
        super.onPause()
        listDataManager.saveList(liste)
    }
}
