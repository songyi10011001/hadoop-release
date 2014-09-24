/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hdfs.protocol;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.crypto.CipherSuite;

/**
 * A simple class for representing an encryption zone. Presently an encryption
 * zone only has a path (the root of the encryption zone), a key name, and a
 * unique id. The id is used to implement batched listing of encryption zones.
 */
@InterfaceAudience.Public
@InterfaceStability.Evolving
public class EncryptionZone {

  private final long id;
  private final String path;
  private final CipherSuite suite;
  private final String keyName;

  public EncryptionZone(long id, String path,
      CipherSuite suite, String keyName) {
    this.id = id;
    this.path = path;
    this.suite = suite;
    this.keyName = keyName;
  }

  public long getId() {
    return id;
  }

  public String getPath() {
    return path;
  }

  public CipherSuite getSuite() {
    return suite;
  }

  public String getKeyName() {
    return keyName;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(13, 31).
      append(id).append(path).
      append(suite).append(keyName).
      toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }

    EncryptionZone rhs = (EncryptionZone) obj;
    return new EqualsBuilder().
      append(id, rhs.id).
      append(path, rhs.path).
      append(suite, rhs.suite).
      append(keyName, rhs.keyName).
      isEquals();
  }

  @Override
  public String toString() {
    return "EncryptionZone [id=" + id +
        ", path=" + path +
        ", suite=" + suite +
        ", keyName=" + keyName + "]";
  }
}
