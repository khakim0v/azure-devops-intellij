// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the project root.

package com.microsoft.alm.plugin.idea.tfvc.core;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.project.Project;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Service(Service.Level.PROJECT)
public final class TfvcDisposable implements Disposable {
    private final CoroutineScope coroutineScope;

    public TfvcDisposable(@NotNull CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
    }

    @NotNull
    public CoroutineScope getCoroutineScope() {   
        return coroutineScope;
    }
    
    // @NotNull
    // public CoroutineScope childScope(@NotNull String name) {
    //     // TODO: Use intellij platform's internal childScope extension function
    // }

    @Override
    public void dispose() {
    }

    @NotNull
    public static TfvcDisposable getInstance(@NotNull Project project) {
        return project.getService(TfvcDisposable.class);
    }
}
