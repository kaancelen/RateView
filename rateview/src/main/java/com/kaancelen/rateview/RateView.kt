package com.kaancelen.rateview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton

class RateView : LinearLayout {

    companion object {
        const val DEFAULT_COUNT = 5
        val DEFAULT_RESOURCE = R.drawable.ic_star_selector
    }

    private lateinit var view: View
    private lateinit var root: LinearLayout

    private var count: Int = DEFAULT_COUNT
    private var selectorResource: Int = DEFAULT_RESOURCE
    private var items: ArrayList<RadioButton> = arrayListOf()
    private lateinit var listener: (Int) -> Unit

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)
    {
        obtainAttributes(attrs)
        initializeViews()
    }

    fun onChangeListener(listener: (Int) -> Unit) {
        this.listener = listener
    }

    fun getLastSelected() : Int {
        return getPoint()
    }

    private fun obtainAttributes(attrs: AttributeSet?) {
        attrs?.let {
            val arr = context.obtainStyledAttributes(attrs, R.styleable.RateView)

            count = arr.getInt(R.styleable.RateView_kc_count, DEFAULT_COUNT)
            selectorResource = arr.getResourceId(R.styleable.RateView_kc_selector_resource, DEFAULT_RESOURCE)

            arr.recycle()
        }
    }

    private fun initializeViews() {
        view = LayoutInflater.from(context)
            .inflate(R.layout.view_rate, this, true)
        root = view.findViewById(R.id.root)
        create()
    }

    private fun create() {
        clear()
        for (index in 0 until count) {
            val item = createItem()

            root.addView(item)
            items.add(item)

            item.setOnClickListener {
                it.preventClickRush()
                setPoint(index)
                if(::listener.isInitialized) {
                    listener(getPoint())
                }
            }
        }
    }

    private fun createItem() : RadioButton {
        val radioButton = RadioButton(context)
        radioButton.layoutParams = LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f)
        radioButton.setButtonDrawable(selectorResource)
        return radioButton
    }

    private fun clear() {
        root.removeAllViews()
        items.clear()
    }

    private fun setPoint(selected: Int) {
        for (index in 0 until count) {
            items[index].isChecked = (selected >= index)
        }
    }

    private fun getPoint() : Int {
        for (index in (count - 1) downTo 0) {
            if(items[index].isChecked) {
                return (index + 1)
            }
        }

        return 0
    }
}