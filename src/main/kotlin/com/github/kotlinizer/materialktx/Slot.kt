package com.github.kotlinizer.materialktx

import kotlinx.html.CommonAttributeGroupFacade

var CommonAttributeGroupFacade.slot: String
    get() = attributes["slot"] ?: ""
    set(newValue) {
        attributes["slot"] = newValue
    }