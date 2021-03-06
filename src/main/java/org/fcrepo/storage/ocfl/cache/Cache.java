/*
 * Licensed to DuraSpace under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.
 *
 * DuraSpace licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fcrepo.storage.ocfl.cache;

import java.util.function.Function;

/**
 * Cache interface
 *
 * @param <K> type of cache key
 * @param <V> type of cache value
 *
 * @author pwinckles
 */
public interface Cache<K,V> {

    /**
     * Retrieves a value from the cache. If it doesn't exist, the loader is called to load the object, which is then
     * cached and returned.
     *
     * @param key to lookup in the cache
     * @param loader function to call to load the object if it's not found
     * @return the object that maps to the key
     */
    V get(final K key, final Function<K, V> loader);

    /**
     * Inserts a value into the cache.
     *
     * @param key key
     * @param value value
     */
    void put(final K key, final V value);

    /**
     * Invalidates the key in the cache.
     *
     * @param key key
     */
    void invalidate(final K key);

    /**
     * Invalidates the keys provided in the cache.
     *
     * @param keys the keys.
     */
    void invalidateAll(final Iterable<K> keys);

    /**
     * Invalidate the entire cache.
     */
    void invalidateAll();
}
