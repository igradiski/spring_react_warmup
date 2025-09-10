package com.example.card.manager.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum ERole {

    ROLE_USER(1),
    ROLE_MODERATOR(2),
    ROLE_ADMIN(3);


    private Integer value;

    ERole(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static ERole fromValue(Integer value) {
        for (ERole enumeration : ERole.values()) {
            if (enumeration.getValue().equals(value)) {
                return enumeration;
            }
        }
        return null;
    }

    @Converter(autoApply = true)
    @SuppressWarnings("unused")
    public static class RoleKorisnikEnumConverter implements AttributeConverter<ERole, Integer> {

        @Override
        public Integer convertToDatabaseColumn(ERole enumeration) {
            return enumeration != null ? enumeration.getValue() : null;
        }

        @Override
        public ERole convertToEntityAttribute(Integer value) {
            return ERole.fromValue(value);
        }
    }


}