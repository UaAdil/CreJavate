package Modules.module6.lab5;

import java.util.ArrayList;
import java.util.List;
public interface IPrototype {
    IPrototype clone();
}
class DocumentManager {
    public IPrototype createDocument(IPrototype prototype) {
        return prototype.clone();
    }
}

class Section implements IPrototype {
    private String title;
    private String text;

    public Section(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public IPrototype clone() {
        return new Section(this.title, this.text);
    }

    @Override
    public String toString() {
        return "Section{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}


class Image implements IPrototype {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public IPrototype clone() {
        return new Image(this.url);
    }

    @Override
    public String toString() {
        return "Image{" +
                "url='" + url + '\'' +
                '}';
    }
}

class Document implements IPrototype {
    private String title;
    private String content;
    private List<Section> sections;
    private List<Image> images;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
        this.sections = new ArrayList<>();
        this.images = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public List<Section> getSections() {
        return sections;
    }

    public List<Image> getImages() {
        return images;
    }

    @Override
    public IPrototype clone() {
        Document clonedDocument = new Document(this.title, this.content);
        for (Section section : this.sections) {
            clonedDocument.addSection((Section) section.clone());
        }
        for (Image image : this.images) {
            clonedDocument.addImage((Image) image.clone());
        }
        return clonedDocument;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sections=" + sections +
                ", images=" + images +
                '}';
    }
}
