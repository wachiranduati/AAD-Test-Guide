package com.nduati.aadtestguide

internal fun TestCategories() : List<TestGuidlineCategories> {
    return listOf(
            TestGuidlineCategories("Android Core", R.id.action_homeFragment_to_androidCoreFragment),
            TestGuidlineCategories("User Interface", R.id.action_homeFragment_to_androidCoreFragment),
            TestGuidlineCategories("Data Management", R.id.action_homeFragment_to_notesFragment),
            TestGuidlineCategories("Debugging", R.id.action_homeFragment_to_debugFragment),
            TestGuidlineCategories("Testing", R.id.action_homeFragment_to_androidCoreFragment)
    )
}