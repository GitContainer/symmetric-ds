package org.jumpmind.symmetric.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OutgoingBatch implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum Status {
        NE, SE, ER, OK;
    }

    private String batchId;

    private String nodeId;

    private String channelId;

    private Status status;

    private BatchType batchType = BatchType.EVENTS;

    public OutgoingBatch() {
    }
    
    public OutgoingBatch(Node client, String channelId, BatchType batchType) {
        this.nodeId = client.getNodeId();
        this.channelId = channelId;
        this.status = Status.NE;
        this.batchType = batchType;
    }
    

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String locationId) {
        this.nodeId = locationId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public BatchType getBatchType() {
        return batchType;
    }
    
    public List<BatchInfo> getBatchInfoList() {
        List<BatchInfo> list = new ArrayList<BatchInfo>();
        list.add(new BatchInfo(this.batchId));
        return list;
    }

    public void setBatchType(BatchType batchType) {
        this.batchType = batchType;
    }

    public void setBatchType(String batchType) {
        if (BatchType.EVENTS.getCode().equals(batchType)) {
            this.batchType = BatchType.EVENTS;
        } else if (BatchType.INITIAL_LOAD.getCode().equals(batchType)) {
            this.batchType = BatchType.INITIAL_LOAD;
        } else {
            batchType = null;
        }
    }

}
