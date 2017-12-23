/**
 * 各种分布式锁的实现
 * 1、Redis
 * 2、ZK
 * 3、MySQL: 基于
 * 4 ...
 *
 * TODO by derek.wq
 * 增加Lock抽象层，底层是各自实现，对外提供统一的 lock api
 *
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
package com.derek.stick.lock;
