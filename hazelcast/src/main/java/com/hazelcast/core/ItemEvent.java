/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.core;

import java.util.EventObject;

/**
 * Map Item event.
 *
 * @see com.hazelcast.core.EntryEvent
 * @see com.hazelcast.core.ICollection#addItemListener(ItemListener, boolean)
 */

public class ItemEvent<E> extends EventObject {

    private final E item;
    private final ItemEventType eventType;
    private final Member member;

    public ItemEvent(String name, int eventType, E item, Member member) {
        this(name, ItemEventType.getByType(eventType), item, member);
    }

    public ItemEvent(String name, ItemEventType itemEventType, E item, Member member) {
        super(name);
        this.item = item;
        this.eventType = itemEventType;
        this.member = member;
    }

    /**
     * Returns the event type.
     *
     * @return the event type.
     */
    public ItemEventType getEventType() {
        return eventType;
    }

    /**
     * Returns the item related to event.
     *
     * @return the item.
     */
    public E getItem() {
        return item;
    }

    /**
     * Returns the member fired this event.
     *
     * @return the member fired this event.
     */
    public Member getMember() {
        return member;
    }

    @Override
    public String toString() {
        return "ItemEvent{"
                + "event=" + eventType
                + ", item=" + getItem()
                + ", member=" + getMember()
                + "} ";
    }
}
