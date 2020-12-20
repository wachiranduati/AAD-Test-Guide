package com.nduati.aadtestguide

internal fun TestCategories() : List<TestGuidlineCategories> {
    return listOf(
            TestGuidlineCategories("Android Core"),
            TestGuidlineCategories("User Interface"),
            TestGuidlineCategories("Data Management"),
            TestGuidlineCategories("Debugging"),
            TestGuidlineCategories("Testing")
    )
}