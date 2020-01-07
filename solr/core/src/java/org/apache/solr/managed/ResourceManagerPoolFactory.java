/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.solr.managed;

import java.util.Map;

/**
 * Factory for creating instances of {@link ResourceManagerPool}-s.
 */
public interface ResourceManagerPoolFactory {

  /**
   * Create a pool of a given symbolic type.
   * @param type pool symbolic type
   * @param poolParams pool parameters
   */
  <T extends ManagedComponent> ResourceManagerPool<T> create(String name, String type, ResourceManager resourceManager,
                                                             Map<String, Object> poolLimits, Map<String, Object> poolParams) throws Exception;

  /**
   * Get the implementation class for a component of a given symbolic type.
   * @param type symbolic type
   */
  Class<? extends ManagedComponent> getComponentClassByType(String type);

  /**
   * Get the implementation class for a plugin of a given symbolic type.
   * @param type symbolic type
   */
  Class<? extends ResourceManagerPool> getPoolClassByType(String type);
}