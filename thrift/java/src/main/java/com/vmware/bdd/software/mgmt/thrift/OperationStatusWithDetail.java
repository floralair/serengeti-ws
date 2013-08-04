/***************************************************************************
 * Copyright (c) 2012-2013 VMware, Inc. All Rights Reserved.
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
 ***************************************************************************/
/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.vmware.bdd.software.mgmt.thrift;

import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

public class OperationStatusWithDetail implements org.apache.thrift.TBase<OperationStatusWithDetail, OperationStatusWithDetail._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("OperationStatusWithDetail");

  private static final org.apache.thrift.protocol.TField OPERATION_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("operationStatus", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField CLUSTER_DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("clusterData", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new OperationStatusWithDetailStandardSchemeFactory());
    schemes.put(TupleScheme.class, new OperationStatusWithDetailTupleSchemeFactory());
  }

  public OperationStatus operationStatus; // optional
  public ClusterData clusterData; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OPERATION_STATUS((short)1, "operationStatus"),
    CLUSTER_DATA((short)2, "clusterData");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // OPERATION_STATUS
          return OPERATION_STATUS;
        case 2: // CLUSTER_DATA
          return CLUSTER_DATA;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private _Fields optionals[] = {_Fields.OPERATION_STATUS,_Fields.CLUSTER_DATA};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OPERATION_STATUS, new org.apache.thrift.meta_data.FieldMetaData("operationStatus", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, OperationStatus.class)));
    tmpMap.put(_Fields.CLUSTER_DATA, new org.apache.thrift.meta_data.FieldMetaData("clusterData", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ClusterData.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(OperationStatusWithDetail.class, metaDataMap);
  }

  public OperationStatusWithDetail() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public OperationStatusWithDetail(OperationStatusWithDetail other) {
    if (other.isSetOperationStatus()) {
      this.operationStatus = new OperationStatus(other.operationStatus);
    }
    if (other.isSetClusterData()) {
      this.clusterData = new ClusterData(other.clusterData);
    }
  }

  public OperationStatusWithDetail deepCopy() {
    return new OperationStatusWithDetail(this);
  }

  @Override
  public void clear() {
    this.operationStatus = null;
    this.clusterData = null;
  }

  public OperationStatus getOperationStatus() {
    return this.operationStatus;
  }

  public OperationStatusWithDetail setOperationStatus(OperationStatus operationStatus) {
    this.operationStatus = operationStatus;
    return this;
  }

  public void unsetOperationStatus() {
    this.operationStatus = null;
  }

  /** Returns true if field operationStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetOperationStatus() {
    return this.operationStatus != null;
  }

  public void setOperationStatusIsSet(boolean value) {
    if (!value) {
      this.operationStatus = null;
    }
  }

  public ClusterData getClusterData() {
    return this.clusterData;
  }

  public OperationStatusWithDetail setClusterData(ClusterData clusterData) {
    this.clusterData = clusterData;
    return this;
  }

  public void unsetClusterData() {
    this.clusterData = null;
  }

  /** Returns true if field clusterData is set (has been assigned a value) and false otherwise */
  public boolean isSetClusterData() {
    return this.clusterData != null;
  }

  public void setClusterDataIsSet(boolean value) {
    if (!value) {
      this.clusterData = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case OPERATION_STATUS:
      if (value == null) {
        unsetOperationStatus();
      } else {
        setOperationStatus((OperationStatus)value);
      }
      break;

    case CLUSTER_DATA:
      if (value == null) {
        unsetClusterData();
      } else {
        setClusterData((ClusterData)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OPERATION_STATUS:
      return getOperationStatus();

    case CLUSTER_DATA:
      return getClusterData();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case OPERATION_STATUS:
      return isSetOperationStatus();
    case CLUSTER_DATA:
      return isSetClusterData();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof OperationStatusWithDetail)
      return this.equals((OperationStatusWithDetail)that);
    return false;
  }

  public boolean equals(OperationStatusWithDetail that) {
    if (that == null)
      return false;

    boolean this_present_operationStatus = true && this.isSetOperationStatus();
    boolean that_present_operationStatus = true && that.isSetOperationStatus();
    if (this_present_operationStatus || that_present_operationStatus) {
      if (!(this_present_operationStatus && that_present_operationStatus))
        return false;
      if (!this.operationStatus.equals(that.operationStatus))
        return false;
    }

    boolean this_present_clusterData = true && this.isSetClusterData();
    boolean that_present_clusterData = true && that.isSetClusterData();
    if (this_present_clusterData || that_present_clusterData) {
      if (!(this_present_clusterData && that_present_clusterData))
        return false;
      if (!this.clusterData.equals(that.clusterData))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(OperationStatusWithDetail other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    OperationStatusWithDetail typedOther = (OperationStatusWithDetail)other;

    lastComparison = Boolean.valueOf(isSetOperationStatus()).compareTo(typedOther.isSetOperationStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOperationStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.operationStatus, typedOther.operationStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetClusterData()).compareTo(typedOther.isSetClusterData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClusterData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.clusterData, typedOther.clusterData);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("OperationStatusWithDetail(");
    boolean first = true;

    if (isSetOperationStatus()) {
      sb.append("operationStatus:");
      if (this.operationStatus == null) {
        sb.append("null");
      } else {
        sb.append(this.operationStatus);
      }
      first = false;
    }
    if (isSetClusterData()) {
      if (!first) sb.append(", ");
      sb.append("clusterData:");
      if (this.clusterData == null) {
        sb.append("null");
      } else {
        sb.append(this.clusterData);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (operationStatus != null) {
      operationStatus.validate();
    }
    if (clusterData != null) {
      clusterData.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class OperationStatusWithDetailStandardSchemeFactory implements SchemeFactory {
    public OperationStatusWithDetailStandardScheme getScheme() {
      return new OperationStatusWithDetailStandardScheme();
    }
  }

  private static class OperationStatusWithDetailStandardScheme extends StandardScheme<OperationStatusWithDetail> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, OperationStatusWithDetail struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OPERATION_STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.operationStatus = new OperationStatus();
              struct.operationStatus.read(iprot);
              struct.setOperationStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CLUSTER_DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.clusterData = new ClusterData();
              struct.clusterData.read(iprot);
              struct.setClusterDataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, OperationStatusWithDetail struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.operationStatus != null) {
        if (struct.isSetOperationStatus()) {
          oprot.writeFieldBegin(OPERATION_STATUS_FIELD_DESC);
          struct.operationStatus.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.clusterData != null) {
        if (struct.isSetClusterData()) {
          oprot.writeFieldBegin(CLUSTER_DATA_FIELD_DESC);
          struct.clusterData.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class OperationStatusWithDetailTupleSchemeFactory implements SchemeFactory {
    public OperationStatusWithDetailTupleScheme getScheme() {
      return new OperationStatusWithDetailTupleScheme();
    }
  }

  private static class OperationStatusWithDetailTupleScheme extends TupleScheme<OperationStatusWithDetail> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, OperationStatusWithDetail struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetOperationStatus()) {
        optionals.set(0);
      }
      if (struct.isSetClusterData()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetOperationStatus()) {
        struct.operationStatus.write(oprot);
      }
      if (struct.isSetClusterData()) {
        struct.clusterData.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, OperationStatusWithDetail struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.operationStatus = new OperationStatus();
        struct.operationStatus.read(iprot);
        struct.setOperationStatusIsSet(true);
      }
      if (incoming.get(1)) {
        struct.clusterData = new ClusterData();
        struct.clusterData.read(iprot);
        struct.setClusterDataIsSet(true);
      }
    }
  }

}

