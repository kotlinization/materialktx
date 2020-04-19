package org.kotlinizer.materialktx

import kotlinx.html.HTMLTag
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class AttributesBoolean<in R : HTMLTag> : ReadWriteProperty<R, Boolean> {

    override fun getValue(thisRef: R, property: KProperty<*>): Boolean {
        return thisRef.attributes[property.name] != null
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: Boolean) {
        if (value) {
            thisRef.attributes[property.name] = ""
        } else {
            thisRef.attributes.remove(property.name)
        }
    }

}
