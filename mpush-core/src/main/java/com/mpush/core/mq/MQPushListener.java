/*
 * (C) Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     ohun@live.cn (夜色)
 */

package com.mpush.core.mq;

import com.mpush.api.spi.push.PushListener;
import com.mpush.api.spi.Spi;
import com.mpush.api.spi.push.PushListenerFactory;

/**
 * Created by ohun on 2016/12/24.
 *
 * @author ohun@live.cn (夜色)
 */
@Spi(order = 2)
public final class MQPushListener implements PushListener<MQPushMessage>, PushListenerFactory<MQPushMessage> {


    @Override
    public void onSuccess(MQPushMessage message) {
        //publish messageId to mq:[success/queue]
    }

    @Override
    public void onAckSuccess(MQPushMessage message) {
        //publish messageId to mq:[success/queue]
    }

    @Override
    public void onBroadcastComplete(MQPushMessage message) {
        //publish messageId to mq:[broadcast/finish/queue]
    }

    @Override
    public void onFailure(MQPushMessage message) {
        //publish messageId to mq:[failure/queue], client can retry
    }

    @Override
    public void onOffline(MQPushMessage message) {
        //publish messageId to mq:[offline/queue], client persist offline message to db
    }

    @Override
    public void onRedirect(MQPushMessage message) {
        //publish messageId to mq:[route/change/queue], client should be try again
    }

    @Override
    public void onAckTimeout(MQPushMessage message) {
        //publish messageId to mq:[ack/timeout/queue], client can retry
    }

    @Override
    public PushListener<MQPushMessage> get() {
        return this;
    }
}