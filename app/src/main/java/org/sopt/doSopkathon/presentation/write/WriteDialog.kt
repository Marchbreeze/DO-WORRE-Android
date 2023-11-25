package org.sopt.doSopkathon.presentation.write

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.sopt.doSopkathon.databinding.DialogWriteBinding
import org.sopt.doSopkathon.util.extension.setOnSingleClickListener

class WriteDialog(
    private val click: () -> Unit = { -> },
) : DialogFragment() {

    private var _binding: DialogWriteBinding? = null
    private val binding: DialogWriteBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DialogWriteBinding.inflate(inflater, container, false)

        // 다이얼로그 뜰 때 배경색 dialog?.window?.setBackgroundDrawableResource(배경색)

        binding.btnWriteDialogHome.setOnSingleClickListener {
            click
        }

        binding.btnWriteDialogWorry.setOnSingleClickListener {
            click
        }

        return binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}