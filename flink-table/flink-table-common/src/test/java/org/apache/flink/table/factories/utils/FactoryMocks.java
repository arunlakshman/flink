/*
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

package org.apache.flink.table.factories.utils;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.ReadableConfig;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.Schema;
import org.apache.flink.table.catalog.CatalogModel;
import org.apache.flink.table.catalog.CatalogTable;
import org.apache.flink.table.catalog.Column;
import org.apache.flink.table.catalog.ObjectIdentifier;
import org.apache.flink.table.catalog.ResolvedCatalogModel;
import org.apache.flink.table.catalog.ResolvedCatalogTable;
import org.apache.flink.table.catalog.ResolvedSchema;
import org.apache.flink.table.connector.sink.DynamicTableSink;
import org.apache.flink.table.connector.source.DynamicTableSource;
import org.apache.flink.table.factories.DynamicTableFactory;
import org.apache.flink.table.factories.FactoryUtil;
import org.apache.flink.table.factories.ModelProviderFactory;
import org.apache.flink.table.ml.ModelProvider;
import org.apache.flink.table.types.DataType;
import org.apache.flink.table.types.logical.RowType;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/** Utilities for testing instances usually created by {@link FactoryUtil}. */
public final class FactoryMocks {

    public static final ResolvedSchema SCHEMA =
            ResolvedSchema.of(
                    Column.physical("a", DataTypes.STRING()),
                    Column.physical("b", DataTypes.INT()),
                    Column.physical("c", DataTypes.BOOLEAN()));

    public static final DataType PHYSICAL_DATA_TYPE = SCHEMA.toPhysicalRowDataType();

    public static final RowType PHYSICAL_TYPE = (RowType) PHYSICAL_DATA_TYPE.getLogicalType();

    public static final ResolvedSchema OUTPUT_SCHEMA =
            ResolvedSchema.of(Column.physical("output", DataTypes.STRING()));

    public static final ObjectIdentifier IDENTIFIER =
            ObjectIdentifier.of("default", "default", "t1");

    public static final ObjectIdentifier MODEL_IDENTIFIER =
            ObjectIdentifier.of("default", "default", "m1");

    public static ModelProvider createModelProvider(
            ResolvedSchema inputSchema, ResolvedSchema outputSchema, Map<String, String> options) {
        return FactoryUtil.createModelProvider(
                null,
                MODEL_IDENTIFIER,
                ResolvedCatalogModel.of(
                        CatalogModel.of(
                                Schema.newBuilder().fromResolvedSchema(inputSchema).build(),
                                Schema.newBuilder().fromResolvedSchema(outputSchema).build(),
                                options,
                                "mock model"),
                        inputSchema,
                        outputSchema),
                new Configuration(),
                FactoryMocks.class.getClassLoader(),
                false);
    }

    public static DynamicTableSource createTableSource(
            ResolvedSchema schema, Map<String, String> options) {
        return createTableSource(schema, options, new Configuration());
    }

    public static DynamicTableSource createTableSource(
            ResolvedSchema schema, Map<String, String> options, ReadableConfig readableConfig) {
        return FactoryUtil.createDynamicTableSource(
                null,
                IDENTIFIER,
                new ResolvedCatalogTable(
                        CatalogTable.newBuilder()
                                .schema(Schema.newBuilder().fromResolvedSchema(schema).build())
                                .comment("mock source")
                                .options(options)
                                .build(),
                        schema),
                Collections.emptyMap(),
                readableConfig,
                FactoryMocks.class.getClassLoader(),
                false);
    }

    public static DynamicTableSink createTableSink(
            ResolvedSchema schema, Map<String, String> options) {
        return createTableSink(schema, Collections.emptyList(), options);
    }

    public static DynamicTableSink createTableSink(
            ResolvedSchema schema, List<String> partitionKeys, Map<String, String> options) {
        return FactoryUtil.createDynamicTableSink(
                null,
                IDENTIFIER,
                new ResolvedCatalogTable(
                        CatalogTable.newBuilder()
                                .schema(Schema.newBuilder().fromResolvedSchema(schema).build())
                                .comment("mock source")
                                .partitionKeys(partitionKeys)
                                .options(options)
                                .build(),
                        schema),
                Collections.emptyMap(),
                new Configuration(),
                FactoryMocks.class.getClassLoader(),
                false);
    }

    public static ModelProviderFactory.Context createModelContext(
            ResolvedSchema schema, ResolvedSchema outputSchema, Map<String, String> options) {
        return new FactoryUtil.DefaultModelProviderContext(
                MODEL_IDENTIFIER,
                ResolvedCatalogModel.of(
                        CatalogModel.of(
                                Schema.newBuilder().fromResolvedSchema(schema).build(),
                                Schema.newBuilder().fromResolvedSchema(outputSchema).build(),
                                options,
                                "mock model"),
                        schema,
                        outputSchema),
                new Configuration(),
                FactoryMocks.class.getClassLoader(),
                false);
    }

    public static DynamicTableFactory.Context createTableContext(
            ResolvedSchema schema, Map<String, String> options) {
        return createTableContext(schema, options, Collections.emptyMap());
    }

    public static DynamicTableFactory.Context createTableContext(
            ResolvedSchema schema,
            Map<String, String> options,
            Map<String, String> enrichmentOptions) {
        return new FactoryUtil.DefaultDynamicTableContext(
                IDENTIFIER,
                new ResolvedCatalogTable(
                        CatalogTable.newBuilder()
                                .schema(Schema.newBuilder().fromResolvedSchema(schema).build())
                                .comment("mock context")
                                .options(options)
                                .build(),
                        schema),
                enrichmentOptions,
                new Configuration(),
                FactoryMocks.class.getClassLoader(),
                false);
    }

    private FactoryMocks() {
        // no instantiation
    }
}
