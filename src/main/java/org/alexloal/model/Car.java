package org.alexloal.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;

@MongoEntity(collection = "cars", clientName = "car")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class Car {

    @BsonProperty("name")
    private String name;

    @BsonProperty("colour")
    private String colour;
}
