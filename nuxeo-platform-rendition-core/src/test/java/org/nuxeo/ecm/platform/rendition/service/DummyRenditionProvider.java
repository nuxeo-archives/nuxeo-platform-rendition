package org.nuxeo.ecm.platform.rendition.service;

import java.util.ArrayList;
import java.util.List;

import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.impl.blob.StringBlob;
import org.nuxeo.ecm.platform.rendition.RenditionException;
import org.nuxeo.ecm.platform.rendition.extension.RenditionProvider;

public class DummyRenditionProvider implements RenditionProvider {

    @Override
    public boolean isAvailable(DocumentModel doc, RenditionDefinition def) {
        return true;
    }

    @Override
    public List<Blob> render(DocumentModel doc, RenditionDefinition definition)
            throws RenditionException {
        try {
            StringBlob blob = new StringBlob(doc.getTitle());
            List<Blob> blobs = new ArrayList<Blob>();
            blobs.add(blob);
            return blobs;
        } catch (ClientException e) {
            throw new RenditionException("Unable to dummy render doc", e);

        }
    }

}
