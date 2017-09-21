package com.pacemaker.blackarchive

import com.pacemaker.blackarchive.documents.RegisterDocumentRequest

def inspect(RegisterDocumentRequest request) {
    if (request.title.empty) {
        throw new IllegalArgumentException("Title is required!")
    }
}

