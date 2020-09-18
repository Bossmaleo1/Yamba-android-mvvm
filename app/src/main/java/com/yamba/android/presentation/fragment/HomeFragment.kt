package com.yamba.android.presentation.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.yamba.android.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var biometricPrompt: BiometricPrompt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //biometricPrompt = createBiometricPrompt()
        //BiometricImplementation()

        biometric_login.setOnClickListener {

        }
    }

    private fun BiometricImplementation() {

        val promptInfo = createPromptInfo()

        if (BiometricManager.from(activity!!)
                .canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS
        ) {
            biometricPrompt.authenticate(promptInfo)
        } else {
            Toast.makeText(activity, " Test de Sidney !!", Toast.LENGTH_LONG).show()
        }

    }

    private fun createBiometricPrompt(): BiometricPrompt {
        val executor = ContextCompat.getMainExecutor(activity)

        val callback = object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Log.d("TAG", "$errorCode :: $errString")
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    //loginWithPassword() // Because in this app, the negative button allows the user to enter an account password. This is completely optional and your app doesn’t have to do it.
                }
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Log.d("TAG", "Authentication failed for an unknown reason")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Log.d("TAG", "Authentication was successful")
                // Proceed with viewing the private encrypted message.
                //showEncryptedMessage(result.cryptoObject)
            }
        }

        val biometricPrompt = BiometricPrompt(this, executor, callback)
        return biometricPrompt
    }


    private fun createPromptInfo(): BiometricPrompt.PromptInfo {
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(getString(R.string.prompt_info_title))
            .setSubtitle(getString(R.string.prompt_info_subtitle))
            .setDescription(getString(R.string.prompt_info_description))
            // Authenticate without requiring the user to press a "confirm"
            // button after satisfying the biometric check
            .setConfirmationRequired(false)
            .setNegativeButtonText(getString(R.string.prompt_info_use_app_password))
            .build()
        return promptInfo
    }


}