
# --------------------------Layout dos Fragments--------------------------
```
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">


</androidx.constraintlayout.widget.ConstraintLayout>
```


# -------------------------- Main Layout --------------------------

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_nav"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        android:background="#FFFFFF"
        app:menu="@menu/menu_navigation" />

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragmentContainerView"
        android:name="com.example.menudenoticias.EntretenimentoFragment"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"

        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>

# --------------------------Dependences--------------------------

    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.fragment:fragment-ktx:1.8.9")

# --------------------------Versions --------------------------
```
agp = "8.8.0"
kotlin = "1.9.24"
coreKtx = "1.15.0"
junit = "4.13.2"
junitVersion = "1.3.0"
espressoCore = "3.7.0"
appcompat = "1.7.1"
material = "1.13.0"
activity = "1.10.0"
constraintlayout = "2.2.1"
fragment = "1.8.9"
```
