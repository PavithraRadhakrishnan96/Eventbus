package com.example.eventbus

import org.greenrobot.eventbus.EventBus




class GlobusEventBus {
    private var sBus: EventBus? = null
   fun getBus(): EventBus? {
        if (sBus == null) sBus = EventBus.getDefault()
        return sBus
    }

}