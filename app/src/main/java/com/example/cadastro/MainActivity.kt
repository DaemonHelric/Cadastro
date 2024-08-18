package com.example.cadastro

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nomeEditText: EditText = findViewById(R.id.editTextNome)
        val telefoneEditText: EditText = findViewById(R.id.editTextTelefone)
        val emailEditText: EditText = findViewById(R.id.editTextEmail)
        val cidadeEditText: EditText = findViewById(R.id.editTextCidade)
        val ufSpinner: Spinner = findViewById(R.id.spinnerUF)
        val emailCheckBox: CheckBox = findViewById(R.id.checkBoxEmailList)
        val radioGroupSexo: RadioGroup = findViewById(R.id.radioGroupSexo)
        val salvarButton: Button = findViewById(R.id.buttonSalvar)
        val limparButton: Button = findViewById(R.id.buttonLimpar)

        salvarButton.setOnClickListener{
            val nome = nomeEditText.text.toString()
            val telefone = telefoneEditText.text.toString()
            val email = emailEditText.text.toString()
            val ingressarListaEmail = emailCheckBox.isChecked
            val sexo = when (radioGroupSexo.checkedRadioButtonId) {
                R.id.radioButtonMasculino -> "Masculino"
                R.id.radioButtonFeminino -> "Feminino"
                else -> ""
            }
            val cidade = cidadeEditText.text.toString()
            val uf = ufSpinner.selectedItem.toString()

            val form = Formulario(nome, telefone, email, ingressarListaEmail, sexo, cidade, uf)

            Toast.makeText(this, form.toString(), Toast.LENGTH_LONG).show()
        }

        limparButton.setOnClickListener{
            nomeEditText.text.clear()
            telefoneEditText.text.clear()
            emailEditText.text.clear()
            emailCheckBox.isChecked = false
            radioGroupSexo.clearCheck()
            cidadeEditText.text.clear()
            ufSpinner.setSelection(0)
        }
    }
}