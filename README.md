# RateView
[![](https://jitpack.io/v/kaancelen/RateView.svg)](https://jitpack.io/#kaancelen/RateView)

RateView is a custom rating view that allows user to set number of items and drawables.
Default count is 5 and default resources like below.



## How To Use
### Install
from JitPack:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```gradle
dependencies {
    implementation 'com.github.kaancelen:RateView:1.0.0'
}
```

### In Xml
```xml
<com.kaancelen.rateview.RateView
    android:id="@+id/rate_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:kc_selector_resource="@drawable/ic_star_selector"
    app:kc_count="5"/>
```
You can create your own drawables and pass as parameter
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_checked="true" android:drawable="@drawable/ic_star_selected"/>
    <item android:state_checked="false" android:drawable="@drawable/ic_star_default"/>
</selector>
```
### In Your Code
You can observe the selection
```java
val rateView = findViewById<RateView>(R.id.rate_view)
rateView.onChangeListener {
    Toast.makeText(this, "Selected $it", Toast.LENGTH_LONG).show()
}
```
Or you can get the last selection
```java
rateView.getLastSelected()
```

## License
```
MIT License

Copyright (c) 2020 kaancelen

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
