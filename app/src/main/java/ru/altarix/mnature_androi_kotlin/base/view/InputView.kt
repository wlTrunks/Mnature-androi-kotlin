package ru.altarix.mnature_androi_kotlin.base.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.StringRes
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import kotlinx.android.synthetic.main.input_view.view.*
import ru.altarix.mnature_androi_kotlin.R
import ru.altarix.mnature_androi_kotlin.base.utils.AppTextUtils

/**
 * Created by Trunks on 01.06.2017.
 */

class InputView : LinearLayout, TextWatcher {

    var inputType: Int = -1
    var maxChars: Int = 100
    var iconRes: Drawable? = null
    var iconVisible: Boolean = false
    var required: Boolean = false
    internal var focusable: Boolean = true
    var hint: String = ""
    var error: String = ""
    internal var onTextChangedListener: OnTextChangedListener? = null


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context, attrs, defStyleAttr)
    }

    private fun initView(context: Context, attrs: AttributeSet, defStyleAttr: Int) {
        LayoutInflater.from(context).inflate(R.layout.input_view, this, true)
        val a = context.obtainStyledAttributes(attrs, R.styleable.InputView, defStyleAttr, 0)

        inputType = a.getInt(R.styleable.InputView_input_type, 1)
        maxChars = a.getInteger(R.styleable.InputView_max_chars, 100)
        iconRes = a.getDrawable(R.styleable.InputView_icon)
        iconVisible = a.getBoolean(R.styleable.InputView_icon_visible, false)
        hint = a.getString(R.styleable.InputView_hint_str)
        required = a.getBoolean(R.styleable.InputView_required, false)
        error = a.getString(R.styleable.InputView_error_str)
        focusable = a.getBoolean(R.styleable.InputView_focusable, true)
        hint = if (required) "$hint*" else hint
        setErrorString(error)
        edit_text.inputType = inputType
        edit_text.addTextChangedListener(this)
        edit_text.hint = hint
        edit_text.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxChars))
        icon.setImageDrawable(iconRes)
        if (iconVisible) {
            icon.visibility = View.VISIBLE
        } else {
            icon.visibility = View.GONE
        }
        textInputLayout.setHintTextAppearance(R.style.InputView)
        a.recycle()
    }


    fun setText(newText: String) {
        if (AppTextUtils.isEmpty(newText)) {
            edit_text.setText("")
        } else {
            edit_text.setText(newText)
        }
    }

    fun check(showError: Boolean, scrollView: ScrollView): Boolean {
        val s = edit_text.getText().toString()
        val result = !AppTextUtils.isEmpty(s) || !required
        if (!result && showError) {
            showError()
            scrollView.scrollTo(0, bottom - height)
        }
        return result
    }

    fun check(showError: Boolean): Boolean {
        val s = edit_text.getText().toString()
        val result = !AppTextUtils.isEmpty(s) || !required
        if (!result && showError) {
            showError()
        }
        return result
    }

    fun setErrorString(@StringRes error: Int) {
        setErrorString(context.getString(error))
    }

    fun setErrorString(error: String) {
        this.error = error
    }

    fun showError() {
        showError(error)
    }

    fun showError(error: String) {
        textInputLayout.error = error
        edit_text.requestFocus()
    }

    fun hideError() {
        textInputLayout.error = null
    }

    fun getText(): String = edit_text.text.toString().trim()

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        hideError()
        if (s!!.isNotEmpty()) {
            if (required) {
                textInputLayout.hint = getHintWithoutAsterisk()
            } else {
                textInputLayout.hint = hint
            }
        } else {
            textInputLayout.hint = null
            edit_text.setHint(hint)
        }
        if (onTextChangedListener != null) onTextChangedListener!!.onTextChanged(s.toString())
    }

    fun getHintWithoutAsterisk(): String {
        return hint.substring(0, hint.length - 1)
    }

    internal fun setError(error: String) {
        textInputLayout.error = error
    }

    fun setOnTextChangedListener(onTextChangedListener: OnTextChangedListener) {
        this.onTextChangedListener = onTextChangedListener
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        textInputLayout.isEnabled = enabled
        edit_text.isEnabled = enabled
        icon.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    override fun setClickable(clickable: Boolean) {
        super.setClickable(clickable)
        edit_text.isClickable = clickable
    }
}

interface OnTextChangedListener {
    fun onTextChanged(text: String)
}