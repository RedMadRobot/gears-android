package com.redmadrobot.eventqueue.flow

import androidx.annotation.StringRes
import com.redmadrobot.eventqueue.Event
import com.redmadrobot.textvalue.TextValue

public data class MessageEvent(val message: TextValue) : Event
public data class ErrorMessageEvent(val message: TextValue) : Event

public fun EventsDispatcher.showMessage(message: String) {
    offerEvent(MessageEvent(TextValue.Plain(message)))
}

public fun EventsDispatcher.showMessage(@StringRes resourceId: Int) {
    offerEvent(MessageEvent(TextValue.Resource(resourceId)))
}

public fun EventsDispatcher.showError(message: String) {
    offerEvent(ErrorMessageEvent(TextValue.Plain(message)))
}

public fun EventsDispatcher.showError(@StringRes resourceId: Int) {
    offerEvent(ErrorMessageEvent(TextValue.Resource(resourceId)))
}
