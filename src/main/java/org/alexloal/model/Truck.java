package org.alexloal.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;

@MongoEntity(collection = "trucks", clientName = "truck")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class Truck {
    
    @BsonProperty("brand")
    private String brand;
    
    @BsonProperty("number_of_wheels")
    private Integer numberOfWheels;
}
